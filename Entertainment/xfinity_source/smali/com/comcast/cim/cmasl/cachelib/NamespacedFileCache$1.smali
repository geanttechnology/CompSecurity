.class Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;
.super Ljava/lang/Object;
.source "NamespacedFileCache.java"

# interfaces
.implements Ljava/io/FilenameFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->removeAll()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;->this$0:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accept(Ljava/io/File;Ljava/lang/String;)Z
    .locals 1
    .param p1, "file"    # Ljava/io/File;
    .param p2, "filename"    # Ljava/lang/String;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;->this$0:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    # getter for: Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->namespace:Ljava/lang/String;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->access$100(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
