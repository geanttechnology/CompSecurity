.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;
.super Ljava/lang/Object;
.source "RetailSearchSuggestionCursorAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateSuggestionItemView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

.field final synthetic val$deleteURL:Ljava/lang/String;

.field final synthetic val$id:Ljava/lang/String;

.field final synthetic val$layout:Landroid/widget/LinearLayout;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;Ljava/lang/String;Ljava/lang/String;Landroid/widget/LinearLayout;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->val$id:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->val$deleteURL:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->val$layout:Landroid/widget/LinearLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 151
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 153
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->val$id:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->val$deleteURL:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;->onDeletePastSearchesClick(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    :cond_0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xa

    if-le v1, v2, :cond_1

    .line 157
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/high16 v1, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 158
    .local v0, "anim":Landroid/view/animation/AlphaAnimation;
    const-wide/16 v1, 0x1f4

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;->setDuration(J)V

    .line 159
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/animation/AlphaAnimation;->setRepeatCount(I)V

    .line 160
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/animation/AlphaAnimation;->setFillAfter(Z)V

    .line 161
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->val$layout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 168
    .end local v0    # "anim":Landroid/view/animation/AlphaAnimation;
    :goto_0
    return-void

    .line 165
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;->val$layout:Landroid/widget/LinearLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method
