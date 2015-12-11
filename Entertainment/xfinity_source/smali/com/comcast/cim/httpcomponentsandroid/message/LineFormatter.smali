.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/message/LineFormatter;
.super Ljava/lang/Object;
.source "LineFormatter.java"


# virtual methods
.method public abstract formatHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/Header;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
.end method

.method public abstract formatRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
.end method

.method public abstract formatStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
.end method
