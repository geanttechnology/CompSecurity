.class public Lcom/poshmark/webcommands/TakePictureCompletionHandler;
.super Lcom/poshmark/webcommands/CommandCompletionHandler;
.source "TakePictureCompletionHandler.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/poshmark/webcommands/CommandCompletionHandler;-><init>()V

    .line 17
    sget-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->PICTURE:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    iput-object v0, p0, Lcom/poshmark/webcommands/TakePictureCompletionHandler;->type:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    .line 18
    return-void
.end method


# virtual methods
.method public handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Lcom/poshmark/webcommands/WebCommand;Landroid/content/Intent;)V
    .locals 8
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;
    .param p2, "command"    # Lcom/poshmark/webcommands/WebCommand;
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 22
    const/4 v0, 0x0

    .line 25
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 26
    const-string v5, "IMAGE_FILE_URI"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    .line 27
    .local v2, "imageFile":Landroid/net/Uri;
    iget-object v5, p2, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v6, "Quality"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 29
    .local v3, "imageQuality":Ljava/lang/String;
    if-eqz v3, :cond_1

    .line 30
    invoke-static {v3}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v5

    const/high16 v6, 0x42c80000    # 100.0f

    mul-float/2addr v5, v6

    float-to-int v4, v5

    .line 35
    .local v4, "imageQualityValue":I
    :goto_0
    invoke-static {v2, v4}, Lcom/poshmark/utils/ImageUtils;->getBitmapAsBase64String(Landroid/net/Uri;I)Ljava/lang/String;

    move-result-object v1

    .line 36
    .local v1, "image":Ljava/lang/String;
    instance-of v5, p1, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v5, :cond_0

    .line 37
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p2, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v7, "OnSuccess"

    invoke-interface {v5, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "(\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\')"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Lcom/poshmark/ui/fragments/MappPageFragment;->fireJSCallback(Ljava/lang/String;)V

    .line 40
    :cond_0
    return-void

    .line 32
    .end local v1    # "image":Ljava/lang/String;
    .end local v4    # "imageQualityValue":I
    :cond_1
    const/16 v4, 0x3c

    .restart local v4    # "imageQualityValue":I
    goto :goto_0
.end method
