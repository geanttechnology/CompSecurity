.class final Lcom/roidapp/photogrid/filter/selfiecam/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/roidapp/photogrid/filter/selfiecam/w;


# instance fields
.field final synthetic a:Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;


# direct methods
.method constructor <init>(Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;)V
    .locals 0

    .prologue
    .line 313
    iput-object p1, p0, Lcom/roidapp/photogrid/filter/selfiecam/e;->a:Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()Ljava/lang/String;
    .locals 2

    .prologue
    .line 322
    iget-object v0, p0, Lcom/roidapp/photogrid/filter/selfiecam/e;->a:Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;

    const v1, 0x7f070227

    invoke-virtual {v0, v1}, Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final a([Ljava/lang/Integer;Z)V
    .locals 8

    .prologue
    .line 317
    iget-object v6, p0, Lcom/roidapp/photogrid/filter/selfiecam/e;->a:Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;

    const/4 v7, 0x0

    new-instance v0, Lcom/roidapp/photogrid/filter/selfiecam/b;

    iget-object v1, p0, Lcom/roidapp/photogrid/filter/selfiecam/e;->a:Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;

    iget-object v2, p0, Lcom/roidapp/photogrid/filter/selfiecam/e;->a:Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;

    invoke-static {v2}, Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;->d(Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;)Ljava/lang/String;

    move-result-object v3

    iget-object v2, p0, Lcom/roidapp/photogrid/filter/selfiecam/e;->a:Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;

    invoke-static {v2}, Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;->b(Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;)Z

    move-result v5

    move-object v2, p1

    move v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/roidapp/photogrid/filter/selfiecam/b;-><init>(Landroid/app/Activity;[Ljava/lang/Integer;Ljava/lang/String;ZZ)V

    invoke-static {v6, v7, v0}, Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;->a(Lcom/roidapp/photogrid/filter/selfiecam/SelfieCamImageEditGLESActivity;ZLcom/roidapp/imagelib/filter/aq;)V

    .line 318
    return-void
.end method

.method public final b()I
    .locals 1

    .prologue
    .line 327
    const/4 v0, 0x1

    return v0
.end method

.method public final c()I
    .locals 1

    .prologue
    .line 332
    const v0, 0x7f0203e8

    return v0
.end method
