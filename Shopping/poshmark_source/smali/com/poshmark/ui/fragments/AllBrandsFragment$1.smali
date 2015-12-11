.class Lcom/poshmark/ui/fragments/AllBrandsFragment$1;
.super Ljava/lang/Object;
.source "AllBrandsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/AllBrandsFragment;->test(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/AllBrandsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/AllBrandsFragment;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AllBrandsFragment$1;->this$0:Lcom/poshmark/ui/fragments/AllBrandsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 54
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2, v2}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 55
    return-void
.end method
