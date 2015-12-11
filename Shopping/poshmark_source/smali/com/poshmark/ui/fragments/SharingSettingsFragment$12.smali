.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$12;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment;->pinterestConnectFinish()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

.field final synthetic val$dialog:Lcom/poshmark/utils/view_holders/PinterestDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Lcom/poshmark/utils/view_holders/PinterestDialog;)V
    .locals 0

    .prologue
    .line 624
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$12;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$12;->val$dialog:Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 627
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$12;->val$dialog:Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-virtual {v0}, Lcom/poshmark/utils/view_holders/PinterestDialog;->dismiss()V

    .line 628
    return-void
.end method
