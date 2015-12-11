.class Lcom/poshmark/ui/fragments/ListingEditorShareFragment$3;
.super Ljava/lang/Object;
.source "ListingEditorShareFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ListingEditorShareFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorShareFragment;)V
    .locals 0

    .prologue
    .line 298
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/16 v3, 0x8

    .line 301
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorShareFragment$3;->this$0:Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    sget v2, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_READ_REQUEST:I

    invoke-virtual {v0, v1, v3, v3, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    .line 302
    return-void
.end method
