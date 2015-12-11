.class public Lcom/squareup/tape/FileException;
.super Ljava/lang/RuntimeException;
.source "FileException.java"


# instance fields
.field private final file:Ljava/io/File;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/io/IOException;Ljava/io/File;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "e"    # Ljava/io/IOException;
    .param p3, "file"    # Ljava/io/File;

    .prologue
    .line 12
    invoke-direct {p0, p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 13
    iput-object p3, p0, Lcom/squareup/tape/FileException;->file:Ljava/io/File;

    .line 14
    return-void
.end method
