/*
 * Copyright (c) 2013 - 2014, Allen A. George <allen dot george at gmail dot com>
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of libraft nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.libraft.kayvee.store;

import com.google.common.base.Objects;
import io.libraft.Command;
import io.libraft.CommittedCommand;

import javax.annotation.Nullable;

final class TestCommittedCommand implements CommittedCommand {

    private final long index;
    private final Command command;

    /**
     * Constructor.
     *
     * @param index index > 0 in the Raft log of the committed {@code Command}
     * @param command the committed {@code Command} instance
     *
     * @see Command
     */
    TestCommittedCommand(long index, Command command) {
        this.index = index;
        this.command = command;
    }

    @Override
    public Type getType() {
        return Type.COMMAND;
    }

    @Override
    public long getIndex() {
        return index;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestCommittedCommand other = (TestCommittedCommand) o;

        return index == other.index && command.equals(other.command);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(index, command);
    }

    @Override
    public String toString() {
        return Objects
                .toStringHelper(this)
                .add("index", index)
                .add("command", command)
                .toString();
    }
}
