.class Lcom/poshmark/ui/fragments/GestureTester$2;
.super Ljava/lang/Object;
.source "GestureTester.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/GestureTester;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/GestureTester;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/GestureTester;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/poshmark/ui/fragments/GestureTester$2;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 74
    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$2;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-boolean v2, v2, Lcom/poshmark/ui/fragments/GestureTester;->isNextClicked:Z

    if-nez v2, :cond_0

    .line 75
    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$2;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/poshmark/ui/fragments/GestureTester;->isNextClicked:Z

    .line 76
    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$2;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/GestureTester;->croppable_view:Lcom/poshmark/ui/customviews/GestureView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/GestureView;->getCroppedImage()Landroid/net/Uri;

    move-result-object v0

    .line 77
    .local v0, "croppedImageFile":Landroid/net/Uri;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 78
    .local v1, "i":Landroid/content/Intent;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 79
    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$2;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    const/4 v3, -0x1

    invoke-virtual {v2, v3, v1}, Lcom/poshmark/ui/fragments/GestureTester;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 81
    .end local v0    # "croppedImageFile":Landroid/net/Uri;
    .end local v1    # "i":Landroid/content/Intent;
    :cond_0
    return-void
.end method
