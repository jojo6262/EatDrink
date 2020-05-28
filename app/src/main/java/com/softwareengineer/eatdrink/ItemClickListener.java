package com.softwareengineer.eatdrink;

import android.view.View;

import java.io.IOException;

public interface ItemClickListener {
    void onClick (View view, int position, boolean isLongClick) throws IOException;

}
