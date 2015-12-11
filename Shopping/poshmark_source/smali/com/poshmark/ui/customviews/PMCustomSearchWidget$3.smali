.class Lcom/poshmark/ui/customviews/PMCustomSearchWidget$3;
.super Ljava/lang/Object;
.source "PMCustomSearchWidget.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMCustomSearchWidget;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$3;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x1

    .line 97
    const/4 v3, 0x3

    if-ne p2, v3, :cond_0

    .line 98
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    .line 99
    .local v1, "searchString":Ljava/lang/String;
    new-instance v0, Lcom/poshmark/data_model/models/SuggestedSearchItem;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/SuggestedSearchItem;-><init>()V

    .line 100
    .local v0, "item":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/poshmark/data_model/models/SuggestedSearchItem;->kw:Ljava/lang/String;

    .line 101
    const-string v3, "kw"

    iput-object v3, v0, Lcom/poshmark/data_model/models/SuggestedSearchItem;->type:Ljava/lang/String;

    .line 102
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMCustomSearchWidget$3;->this$0:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {v3, v0, v2}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->launchSearch(Lcom/poshmark/data_model/models/SuggestedSearchItem;Z)V

    .line 105
    .end local v0    # "item":Lcom/poshmark/data_model/models/SuggestedSearchItem;
    .end local v1    # "searchString":Ljava/lang/String;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method
