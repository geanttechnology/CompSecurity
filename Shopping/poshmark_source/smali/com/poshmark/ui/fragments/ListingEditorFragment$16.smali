.class Lcom/poshmark/ui/fragments/ListingEditorFragment$16;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;->createViewHolder(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0

    .prologue
    .line 1008
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$16;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1011
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$16;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const-string v1, "/mapp/fee_policy"

    const-string v2, "seller_policy_screen"

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->launchUrl(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$500(Lcom/poshmark/ui/fragments/ListingEditorFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 1012
    return-void
.end method
