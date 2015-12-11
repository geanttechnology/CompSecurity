.class Lcom/poshmark/ui/customviews/PMSearchView$4;
.super Ljava/lang/Object;
.source "PMSearchView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMSearchView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMSearchView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMSearchView;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMSearchView$4;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 184
    invoke-static {}, Lcom/poshmark/controllers/SavedSearchController;->getGlobalSavedSearchController()Lcom/poshmark/controllers/SavedSearchController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/SavedSearchController;->clearAll()V

    .line 185
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView$4;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMSearchView$4;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMSearchView;->getQuery()Ljava/lang/CharSequence;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/customviews/PMSearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 186
    return-void
.end method
