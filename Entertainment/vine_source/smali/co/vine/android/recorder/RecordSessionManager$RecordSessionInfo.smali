.class public Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;
.super Ljava/lang/Object;
.source "RecordSessionManager.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/RecordSessionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecordSessionInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;",
        ">;"
    }
.end annotation


# instance fields
.field public final folder:Ljava/io/File;

.field public final meta:Lco/vine/android/recorder/RecordSessionMeta;

.field public final thumb:Ljava/io/File;

.field public final video:Ljava/io/File;


# direct methods
.method public constructor <init>(Ljava/io/File;Ljava/io/File;Ljava/io/File;Lco/vine/android/recorder/RecordSessionMeta;)V
    .locals 0
    .param p1, "folder"    # Ljava/io/File;
    .param p2, "thumb"    # Ljava/io/File;
    .param p3, "video"    # Ljava/io/File;
    .param p4, "meta"    # Lco/vine/android/recorder/RecordSessionMeta;

    .prologue
    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 185
    iput-object p1, p0, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->folder:Ljava/io/File;

    .line 186
    iput-object p2, p0, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->thumb:Ljava/io/File;

    .line 187
    iput-object p3, p0, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->video:Ljava/io/File;

    .line 188
    iput-object p4, p0, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->meta:Lco/vine/android/recorder/RecordSessionMeta;

    .line 189
    return-void
.end method


# virtual methods
.method public compareTo(Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;)I
    .locals 2
    .param p1, "another"    # Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 193
    iget-object v0, p0, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->folder:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    iget-object v1, p1, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->folder:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 178
    check-cast p1, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;->compareTo(Lco/vine/android/recorder/RecordSessionManager$RecordSessionInfo;)I

    move-result v0

    return v0
.end method
