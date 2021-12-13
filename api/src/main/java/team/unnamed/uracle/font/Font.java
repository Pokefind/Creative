/*
 * This file is part of uracle, licensed under the MIT license
 *
 * Copyright (c) 2021 Unnamed Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package team.unnamed.uracle.font;

import net.kyori.examination.Examinable;
import team.unnamed.uracle.Element;
import team.unnamed.uracle.texture.Texture;

import java.util.List;

/**
 * Represents a Minecraft Resource Pack Font
 * provider
 */
public interface Font extends Element, Element.Part, Examinable {

    /**
     * Returns the type of this font, the font
     * contents depend on it
     *
     * @return The font type
     */
    Type type();

    enum Type {
        BITMAP,
        LEGACY_UNICODE,
        TTF
    }

    /**
     * Creates a new bit-map font from the provided values
     *
     * @param texture The bit-map texture in PNG format
     * @param height The characters height
     * @param ascent The characters ascent
     * @param characters The characters string
     * @return A new bit-map font
     */
    static BitMapFont bitMap(
            Texture texture,
            int height,
            int ascent,
            List<String> characters
    ) {
        return new BitMapFont(texture, height, ascent, characters);
    }

}
