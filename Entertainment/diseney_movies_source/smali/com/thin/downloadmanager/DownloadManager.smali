.class public interface abstract Lcom/thin/downloadmanager/DownloadManager;
.super Ljava/lang/Object;
.source "DownloadManager.java"


# static fields
.field public static final ERROR_DOWNLOAD_CANCELLED:I = 0x3f0

.field public static final ERROR_DOWNLOAD_SIZE_UNKNOWN:I = 0x3ee

.field public static final ERROR_FILE_ERROR:I = 0x3e9

.field public static final ERROR_HTTP_DATA_ERROR:I = 0x3ec

.field public static final ERROR_MALFORMED_URI:I = 0x3ef

.field public static final ERROR_TOO_MANY_REDIRECTS:I = 0x3ed

.field public static final ERROR_UNHANDLED_HTTP_CODE:I = 0x3ea

.field public static final STATUS_FAILED:I = 0x10

.field public static final STATUS_NOT_FOUND:I = 0x20

.field public static final STATUS_PENDING:I = 0x1

.field public static final STATUS_RUNNING:I = 0x4

.field public static final STATUS_STARTED:I = 0x2

.field public static final STATUS_SUCCESSFUL:I = 0x8


# virtual methods
.method public abstract add(Lcom/thin/downloadmanager/DownloadRequest;)I
.end method

.method public abstract cancel(I)I
.end method

.method public abstract cancelAll()V
.end method

.method public abstract query(I)I
.end method

.method public abstract release()V
.end method
