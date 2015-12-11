.class Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;
.super Ljava/lang/Object;
.source "MultiViewToggle.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ClickListener"
.end annotation


# instance fields
.field private final selector:Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;

.field private final type:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "selector"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;
    .param p2, "type"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 146
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 147
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->selector:Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;

    .line 148
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->type:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 149
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .param p3, "x2"    # Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$1;

    .prologue
    .line 140
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 154
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->selector:Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    .line 155
    .local v0, "viewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->type:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    if-ne v0, v1, :cond_1

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 160
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->selector:Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->type:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->setViewType(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 161
    if-eqz v0, :cond_0

    .line 163
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->selector:Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;->access$600(Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/MultiViewToggle$ClickListener;->type:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->recordLayoutSwitch(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
