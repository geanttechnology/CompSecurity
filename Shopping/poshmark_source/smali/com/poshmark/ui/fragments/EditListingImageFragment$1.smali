.class Lcom/poshmark/ui/fragments/EditListingImageFragment$1;
.super Ljava/lang/Object;
.source "EditListingImageFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditListingImageFragment;->setupButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditListingImageFragment;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 150
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 151
    .local v1, "i":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 152
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "EDITMODE"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 153
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 154
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EditListingImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditListingImageFragment;

    const/4 v3, -0x1

    invoke-virtual {v2, v3, v1}, Lcom/poshmark/ui/fragments/EditListingImageFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 155
    return-void
.end method
