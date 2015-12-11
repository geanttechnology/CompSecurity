.class public Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
.super Ljava/io/DataInputStream;
.source "HybiParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/codebutler/android_websockets/HybiParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HappyDataInputStream"
.end annotation


# direct methods
.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "in"    # Ljava/io/InputStream;

    .prologue
    .line 360
    invoke-direct {p0, p1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 361
    return-void
.end method


# virtual methods
.method public readBytes(I)[B
    .locals 1
    .param p1, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 364
    new-array v0, p1, [B

    .line 365
    .local v0, "buffer":[B
    invoke-virtual {p0, v0}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->readFully([B)V

    .line 366
    return-object v0
.end method
