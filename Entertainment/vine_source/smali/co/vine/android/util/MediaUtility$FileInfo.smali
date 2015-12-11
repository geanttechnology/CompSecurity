.class Lco/vine/android/util/MediaUtility$FileInfo;
.super Ljava/lang/Object;
.source "MediaUtility.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/MediaUtility;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FileInfo"
.end annotation


# instance fields
.field public file:Ljava/io/File;

.field public filename:Ljava/lang/String;

.field public uploadKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V
    .locals 0
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "file"    # Ljava/io/File;
    .param p3, "uploadKey"    # Ljava/lang/String;

    .prologue
    .line 194
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 195
    iput-object p1, p0, Lco/vine/android/util/MediaUtility$FileInfo;->filename:Ljava/lang/String;

    .line 196
    iput-object p2, p0, Lco/vine/android/util/MediaUtility$FileInfo;->file:Ljava/io/File;

    .line 197
    iput-object p3, p0, Lco/vine/android/util/MediaUtility$FileInfo;->uploadKey:Ljava/lang/String;

    .line 198
    return-void
.end method
