package com.intellij.keymaps;

import com.intellij.openapi.keymap.impl.BundledKeymapProvider;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author Konstantin Bulenkov
 */
public class VSCodeKeymap implements BundledKeymapProvider {
    @NotNull
    @Override
    public List<String> getKeymapFileNames() {
        return Collections.singletonList("VSCode.xml");
    }

    @Override
    public <R> R load(@NotNull String key, @NotNull Function<? super InputStream, ? extends R> consumer) throws IOException {
        try (InputStream stream = VSCodeKeymap.class.getResourceAsStream("/keymaps/" + key)) {
            return consumer.apply(stream);
        }
    }
}
