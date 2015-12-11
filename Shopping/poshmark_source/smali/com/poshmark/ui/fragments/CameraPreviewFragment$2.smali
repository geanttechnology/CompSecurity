.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$2;
.super Ljava/lang/Object;
.source "CameraPreviewFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0

    .prologue
    .line 274
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$2;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 277
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.GET_CONTENT"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 278
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "image/*"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 279
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$2;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$2;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->PICK_IMAGE:I

    invoke-virtual {v1, v0, v2}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 280
    return-void
.end method
