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
package team.unnamed.uracle.model.block;

import net.kyori.adventure.key.Key;
import net.kyori.examination.ExaminableProperty;
import net.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import team.unnamed.uracle.model.Model;
import team.unnamed.uracle.model.ModelDisplay;
import team.unnamed.uracle.model.ModelElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;
import static java.util.Objects.requireNonNull;

public class BlockModel implements Model {

    public static final Key BUILTIN_GENERATED = Key.key("builtin/generated");

    /**
     * Reference to the parent block model
     * resource location
     */
    private final Key parent;

    /**
     * Determines whether to use ambient occlusion
     * or not for this block
     */
    private final boolean ambientOcclusion;

    /**
     * Holds the different places where block models
     * can be displayed
     */
    private final Map<ModelDisplay.Type, ModelDisplay> display;

    /**
     * Holds the textures of the model
     */
    private final BlockTexture textures;

    /**
     * Contains all the elements of the model. They
     * can only have cubic forms. If both "parent"
     * and "elements" are set, the "elements" tag
     * overrides the "elements" tag from the previous
     * model
     */
    @Unmodifiable private final List<ModelElement> elements;

    private BlockModel(
            Key parent,
            boolean ambientOcclusion,
            Map<ModelDisplay.Type, ModelDisplay> display,
            BlockTexture textures,
            List<ModelElement> elements
    ) {
        requireNonNull(display, "display");
        requireNonNull(elements, "elements");
        this.parent = requireNonNull(parent, "parent");
        this.ambientOcclusion = ambientOcclusion;
        this.display = unmodifiableMap(new HashMap<>(display));
        this.textures = requireNonNull(textures, "textures");
        this.elements = unmodifiableList(new ArrayList<>(elements));
    }

    @Override
    public Key parent() {
        return parent;
    }

    public boolean ambientOcclusion() {
        return ambientOcclusion;
    }

    @Override
    public @Unmodifiable Map<ModelDisplay.Type, ModelDisplay> display() {
        return display;
    }

    public BlockTexture textures() {
        return textures;
    }

    @Override
    public @Unmodifiable List<ModelElement> elements() {
        return elements;
    }

    @Override
    public @NotNull Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(
                ExaminableProperty.of("parent", parent),
                ExaminableProperty.of("ambientocclusion", ambientOcclusion),
                ExaminableProperty.of("display", display),
                ExaminableProperty.of("textures", textures),
                ExaminableProperty.of("elements", elements)
        );
    }

    @Override
    public String toString() {
        return examine(StringExaminer.simpleEscaping());
    }

}