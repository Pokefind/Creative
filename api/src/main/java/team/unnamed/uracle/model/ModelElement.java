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
package team.unnamed.uracle.model;

import team.unnamed.uracle.Axis3D;
import team.unnamed.uracle.CubeFace;
import team.unnamed.uracle.Vector3Float;
import team.unnamed.uracle.Vector4Int;

import java.util.Map;

public class ModelElement {

    /**
     * Start point of a cuboid. Values must be
     * between -16 and 32.
     */
    private Vector3Float from;

    /**
     * Stop point of a cuboid. Values must be
     * between -16 and 32.
     */
    private Vector3Float to;

    private Rotation rotation;

    private boolean shade;

    /**
     * Holds all the faces of the cuboid. If a face is
     * left out, it does not render
     */
    private Map<CubeFace, Face> faces;

    public static class Rotation {

        private Vector3Float origin;

        private Axis3D axis;

        private float angle;

        private boolean rescale;

    }

    public static class Face {

        private Vector4Int uv;

        private String texture;

        private CubeFace cullFace;

        private int rotation;

        private boolean tint;

    }

}