// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk;

import java.io.Reader;
import java.io.Writer;

/**
 * Logger facility for the Chromium debugger connection. It can eavesdrop both
 * incoming and outgoing streams and log them somewhere. To make other code
 * less dependent on this interface, it works by wrapping reader/writer and is
 * only visible at start-up time. This approach has its disadvantages, because
 * it works with raw data streams, which are not perfectly formatted for human
 * reading. E.g. adjacent  requests or responses are not separated even
 * by EOL.  
 */
public interface ConnectionLogger {
  /**
   * @return new writer that should pass all data to {@code streamWriter} and
   * silently copy it elsewhere (without additional exceptions). 
   */
  Writer wrapWriter(Writer streamWriter);

  /**
   * @return new reader that should give access to all data
   * from {@code streamReader} and silently copy it elsewhere (without
   * additional exceptions). 
   */
  Reader wrapReader(Reader streamReader);
}