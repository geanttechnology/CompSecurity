.class public Lcom/wishabi/flipp/widget/SearchView;
.super Landroid/widget/SearchView;
.source "SourceFile"

# interfaces
.implements Landroid/widget/SearchView$OnQueryTextListener;
.implements Landroid/widget/SearchView$OnSuggestionListener;


# instance fields
.field private mClearAfterQuery:Z

.field private mExtraData:Landroid/os/Bundle;

.field private mExtraDataName:Ljava/lang/String;

.field private mQueryHint:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/SearchView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 45
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6

    .prologue
    const v5, 0x7f090066

    const v4, 0x7f0200af

    const/4 v3, 0x0

    .line 48
    invoke-direct {p0, p1, p2}, Landroid/widget/SearchView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 50
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 51
    if-nez v1, :cond_0

    .line 80
    :goto_0
    return-void

    .line 54
    :cond_0
    const-string v0, "android:id/search_button"

    invoke-virtual {v1, v0, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 56
    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 58
    const-string v0, "android:id/search_close_btn"

    invoke-virtual {v1, v0, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 60
    const v2, 0x7f0200a7

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 61
    const v2, 0x7f020001

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 63
    const-string v0, "android:id/search_mag_icon"

    invoke-virtual {v1, v0, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 65
    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 67
    const-string v0, "android:id/search_plate"

    invoke-virtual {v1, v0, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 69
    const v2, 0x7f0200ef

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 71
    const-string v0, "android:id/search_src_text"

    invoke-virtual {v1, v0, v3, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    .line 74
    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/AutoCompleteTextView;->setTextColor(I)V

    .line 75
    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setHintTextColor(I)V

    .line 78
    invoke-virtual {p0, p0}, Lcom/wishabi/flipp/widget/SearchView;->setOnQueryTextListener(Landroid/widget/SearchView$OnQueryTextListener;)V

    .line 79
    invoke-virtual {p0, p0}, Lcom/wishabi/flipp/widget/SearchView;->setOnSuggestionListener(Landroid/widget/SearchView$OnSuggestionListener;)V

    goto :goto_0
.end method

.method private getQueryIntent(Ljava/lang/String;)Landroid/content/Intent;
    .locals 3

    .prologue
    .line 203
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/wishabi/flipp/app/SearchActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 204
    const-string v1, "android.intent.action.SEARCH"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 205
    const-string v1, "query"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 207
    iget-object v1, p0, Lcom/wishabi/flipp/widget/SearchView;->mExtraDataName:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/SearchView;->mExtraData:Landroid/os/Bundle;

    if-eqz v1, :cond_0

    .line 208
    iget-object v1, p0, Lcom/wishabi/flipp/widget/SearchView;->mExtraDataName:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/SearchView;->mExtraData:Landroid/os/Bundle;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 211
    :cond_0
    return-object v0
.end method

.method private getSuggestionQuery(I)Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 215
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->getSuggestionsAdapter()Landroid/widget/CursorAdapter;

    move-result-object v1

    .line 216
    if-nez v1, :cond_1

    .line 234
    :cond_0
    :goto_0
    return-object v0

    .line 221
    :cond_1
    invoke-virtual {v1}, Landroid/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    .line 222
    if-eqz v1, :cond_0

    invoke-interface {v1, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 223
    const-string v2, "suggest_text_1"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 224
    if-ltz v2, :cond_0

    .line 226
    :try_start_0
    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 227
    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private updateHintImage()V
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v8, 0x0

    .line 177
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 178
    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->isIconfiedByDefault()Z

    move-result v0

    if-nez v0, :cond_1

    .line 200
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    const-string v0, "android:id/search_src_text"

    invoke-virtual {v1, v0, v2, v2}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SearchView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    .line 184
    new-instance v2, Landroid/text/SpannableStringBuilder;

    const-string v3, "   "

    invoke-direct {v2, v3}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 185
    const v3, 0x7f0200af

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 186
    if-eqz v3, :cond_0

    .line 187
    invoke-virtual {v0}, Landroid/widget/AutoCompleteTextView;->getTextSize()F

    move-result v4

    float-to-double v4, v4

    const-wide/high16 v6, 0x3ff4000000000000L    # 1.25

    mul-double/2addr v4, v6

    double-to-int v4, v4

    .line 188
    invoke-virtual {v3, v8, v8, v4, v4}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 189
    new-instance v4, Landroid/text/style/ImageSpan;

    invoke-direct {v4, v3}, Landroid/text/style/ImageSpan;-><init>(Landroid/graphics/drawable/Drawable;)V

    const/4 v3, 0x1

    const/4 v5, 0x2

    const/16 v6, 0x21

    invoke-virtual {v2, v4, v3, v5, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 193
    iget-object v3, p0, Lcom/wishabi/flipp/widget/SearchView;->mQueryHint:Ljava/lang/CharSequence;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 194
    const v3, 0x7f0e0120

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/widget/SearchView;->mQueryHint:Ljava/lang/CharSequence;

    .line 197
    :cond_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/SearchView;->mQueryHint:Ljava/lang/CharSequence;

    invoke-virtual {v2, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 198
    invoke-virtual {v0, v2}, Landroid/widget/AutoCompleteTextView;->setHint(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public clearHistory()V
    .locals 1

    .prologue
    .line 171
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/wishabi/flipp/content/aj;->a(Landroid/content/Context;)V

    .line 172
    return-void
.end method

.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 129
    const/4 v0, 0x0

    return v0
.end method

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 3

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 109
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->clearFocus()V

    .line 111
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x3

    if-lt v1, v2, :cond_0

    .line 112
    invoke-static {v0, p1}, Lcom/wishabi/flipp/content/aj;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 114
    :cond_0
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/widget/SearchView;->getQueryIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 115
    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 116
    const v1, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 119
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/SearchView;->mClearAfterQuery:Z

    if-eqz v0, :cond_1

    .line 120
    const-string v0, ""

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 123
    :cond_1
    const/4 v0, 0x1

    return v0
.end method

.method public onSuggestionClick(I)Z
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 140
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 142
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/widget/SearchView;->getSuggestionQuery(I)Ljava/lang/String;

    move-result-object v1

    .line 144
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SearchView;->clearFocus()V

    .line 148
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/widget/SearchView;->getQueryIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 149
    invoke-virtual {v0, v2}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 150
    const v2, 0x7f040001

    const v3, 0x7f040002

    invoke-virtual {v0, v2, v3}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 153
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/SearchView;->mClearAfterQuery:Z

    if-eqz v0, :cond_0

    .line 154
    const-string v0, ""

    invoke-virtual {p0, v0, v4}, Lcom/wishabi/flipp/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 158
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 156
    :cond_0
    invoke-virtual {p0, v1, v4}, Lcom/wishabi/flipp/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    goto :goto_0
.end method

.method public onSuggestionSelect(I)Z
    .locals 1

    .prologue
    .line 135
    const/4 v0, 0x0

    return v0
.end method

.method public setClearAfterQuery(Z)V
    .locals 0

    .prologue
    .line 167
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/SearchView;->mClearAfterQuery:Z

    .line 168
    return-void
.end method

.method public setIconifiedByDefault(Z)V
    .locals 0

    .prologue
    .line 101
    invoke-super {p0, p1}, Landroid/widget/SearchView;->setIconifiedByDefault(Z)V

    .line 102
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/SearchView;->updateHintImage()V

    .line 103
    return-void
.end method

.method public setQueryHint(Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 94
    invoke-super {p0, p1}, Landroid/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 95
    iput-object p1, p0, Lcom/wishabi/flipp/widget/SearchView;->mQueryHint:Ljava/lang/CharSequence;

    .line 96
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/SearchView;->updateHintImage()V

    .line 97
    return-void
.end method

.method public setSearchExtraData(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 162
    iput-object p2, p0, Lcom/wishabi/flipp/widget/SearchView;->mExtraData:Landroid/os/Bundle;

    .line 163
    iput-object p1, p0, Lcom/wishabi/flipp/widget/SearchView;->mExtraDataName:Ljava/lang/String;

    .line 164
    return-void
.end method

.method public setSearchableInfo(Landroid/app/SearchableInfo;)V
    .locals 1

    .prologue
    .line 84
    invoke-super {p0, p1}, Landroid/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 85
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/SearchView;->updateHintImage()V

    .line 87
    const v0, 0x12000003

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SearchView;->setImeOptions(I)V

    .line 90
    return-void
.end method
