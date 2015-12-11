.class public Lcom/amazon/device/utils/DetUtil$PlainBodyWriter;
.super Ljava/lang/Object;
.source "DetUtil.java"

# interfaces
.implements Lcom/amazon/device/utils/DetUtil$BodyWriter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/utils/DetUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PlainBodyWriter"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public write(Ljava/io/BufferedReader;Ljava/io/Writer;)V
    .locals 6
    .param p1, "reader"    # Ljava/io/BufferedReader;
    .param p2, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/16 v5, 0x2000

    const/4 v4, 0x0

    .line 86
    const/16 v1, 0x2000

    .line 87
    .local v1, "bufferSize":I
    new-array v0, v5, [C

    .line 88
    .local v0, "buffer":[C
    const/4 v2, 0x0

    .line 90
    .local v2, "countRead":I
    :goto_0
    invoke-virtual {p1, v0, v4, v5}, Ljava/io/BufferedReader;->read([CII)I

    move-result v2

    .line 91
    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 97
    return-void

    .line 95
    :cond_0
    invoke-virtual {p2, v0, v4, v2}, Ljava/io/Writer;->write([CII)V

    goto :goto_0
.end method
