.class Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;
.super Ljava/lang/Object;
.source "ViewToggle.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/ViewToggle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ClickListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/ViewToggle;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/ViewToggle;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ViewToggle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/ViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewToggle$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/ViewToggle;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewToggle$1;

    .prologue
    .line 93
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewToggle;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 98
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ViewToggle;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v1

    .line 99
    .local v1, "viewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    const/4 v0, 0x0

    .line 101
    .local v0, "newViewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    if-ne v1, v2, :cond_1

    .line 103
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 114
    :goto_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ViewToggle;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v2, v0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->setViewType(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 116
    if-eqz v1, :cond_0

    .line 118
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/ViewToggle$ClickListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/ViewToggle;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/results/ViewToggle;->access$100(Lcom/amazon/retailsearch/android/ui/results/ViewToggle;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->recordLayoutSwitch(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    :cond_0
    return-void

    .line 105
    :cond_1
    sget-object v2, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    if-ne v1, v2, :cond_2

    .line 107
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ListView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    goto :goto_0

    .line 111
    :cond_2
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    goto :goto_0
.end method
