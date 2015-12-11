.class Lcom/poshmark/ui/fragments/CropImageFragment$2;
.super Ljava/lang/Object;
.source "CropImageFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CropImageFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CropImageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CropImageFragment;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CropImageFragment$2;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CropImageFragment$2;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CropImageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 79
    return-void
.end method
