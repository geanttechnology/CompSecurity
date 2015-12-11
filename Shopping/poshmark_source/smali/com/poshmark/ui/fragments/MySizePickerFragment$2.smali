.class Lcom/poshmark/ui/fragments/MySizePickerFragment$2;
.super Ljava/lang/Object;
.source "MySizePickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupClickHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 150
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 151
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/MySizeFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 152
    return-void
.end method
