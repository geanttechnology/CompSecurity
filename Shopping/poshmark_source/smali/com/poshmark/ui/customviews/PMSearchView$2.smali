.class Lcom/poshmark/ui/customviews/PMSearchView$2;
.super Ljava/lang/Object;
.source "PMSearchView.java"

# interfaces
.implements Landroid/widget/SearchView$OnQueryTextListener;


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
    .line 131
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMSearchView$2;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 153
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView$2;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMSearchView;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    if-eqz v0, :cond_1

    .line 155
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMSearchView$2;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMSearchView;->parentListener:Lcom/poshmark/utils/PMSearchViewListener;

    invoke-interface {v0}, Lcom/poshmark/utils/PMSearchViewListener;->clearSearchString()V

    .line 158
    :cond_1
    const/4 v0, 0x0

    return v0
.end method

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 5
    .param p1, "searchString"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 134
    new-instance v0, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/SuggestedSearchItem;-><init>()V

    .line 135
    .local v0, "item":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    .line 136
    const-string v1, "kw"

    iput-object v1, v0, Lcom/poshmark/data_model/models/SuggestedSearchItem;->type:Ljava/lang/String;

    .line 137
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMSearchView$2;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    invoke-virtual {v1, v0, v4}, Lcom/poshmark/ui/customviews/PMSearchView;->launchSearch(Lcom/poshmark/data_model/models/SuggestedSearchItem;Z)V

    .line 138
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMSearchView$2;->this$0:Lcom/poshmark/ui/customviews/PMSearchView;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/ui/customviews/PMSearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 147
    return v4
.end method
