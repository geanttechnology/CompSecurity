.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$3;
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
    .line 284
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$3;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 287
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$3;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 288
    return-void
.end method
