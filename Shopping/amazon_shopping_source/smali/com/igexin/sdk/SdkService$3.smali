.class Lcom/igexin/sdk/SdkService$3;
.super Ljava/lang/Object;
.source "SdkService.java"

# interfaces
.implements Ljava/io/FilenameFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/igexin/sdk/SdkService;->scanThirdPartCids()Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/igexin/sdk/SdkService;


# direct methods
.method constructor <init>(Lcom/igexin/sdk/SdkService;)V
    .locals 0

    .prologue
    .line 565
    iput-object p1, p0, Lcom/igexin/sdk/SdkService$3;->this$0:Lcom/igexin/sdk/SdkService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accept(Ljava/io/File;Ljava/lang/String;)Z
    .locals 1
    .param p1, "dir"    # Ljava/io/File;
    .param p2, "filename"    # Ljava/lang/String;

    .prologue
    .line 569
    const-string/jumbo v0, ".db"

    invoke-virtual {p2, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 570
    const/4 v0, 0x1

    .line 571
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
