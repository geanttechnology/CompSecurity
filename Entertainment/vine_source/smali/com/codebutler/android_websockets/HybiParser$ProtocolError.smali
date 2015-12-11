.class public Lcom/codebutler/android_websockets/HybiParser$ProtocolError;
.super Ljava/io/IOException;
.source "HybiParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/codebutler/android_websockets/HybiParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProtocolError"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 342
    invoke-direct {p0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    .line 343
    return-void
.end method
