.class Lcom/poshmark/ui/fragments/CommentFragment$3;
.super Ljava/lang/Object;
.source "CommentFragment.java"

# interfaces
.implements Landroid/widget/FilterQueryProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CommentFragment;->updateAutoCompleteView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CommentFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CommentFragment;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CommentFragment$3;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runQuery(Ljava/lang/CharSequence;)Landroid/database/Cursor;
    .locals 8
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v0, 0x0

    const/4 v6, 0x2

    const/4 v7, 0x1

    .line 165
    if-eqz p1, :cond_2

    .line 166
    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    .line 167
    .local v2, "newText":Ljava/lang/String;
    const-string v4, " "

    invoke-virtual {v2, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    const/4 v5, -0x1

    if-eq v4, v5, :cond_0

    .line 169
    const-string v4, " "

    invoke-virtual {v2, v4}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    .line 170
    .local v1, "lastIndex":I
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-eq v1, v4, :cond_0

    .line 172
    add-int/lit8 v4, v1, 0x1

    invoke-virtual {v2, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 173
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    if-lt v4, v6, :cond_0

    .line 175
    move-object p1, v2

    .line 179
    .end local v1    # "lastIndex":I
    :cond_0
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    if-le v4, v7, :cond_2

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "@"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 180
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CommentFragment$3;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CommentFragment;->adapter:Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;

    invoke-virtual {v4}, Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v3

    .line 181
    .local v3, "oldCursor":Landroid/database/Cursor;
    if-eqz v3, :cond_1

    .line 182
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    .line 184
    :cond_1
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    new-array v4, v6, [Ljava/lang/String;

    const/4 v5, 0x0

    sget-object v6, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v6, v4, v5

    sget-object v5, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v5, v4, v7

    invoke-direct {v0, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 185
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CommentFragment$3;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CommentFragment;->interactionsData:Lcom/poshmark/data_model/models/UserInteractions;

    invoke-virtual {v2, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v0, v5}, Lcom/poshmark/data_model/models/UserInteractions;->fillFilteredCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;Ljava/lang/CharSequence;)V

    .line 191
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    .end local v2    # "newText":Ljava/lang/String;
    .end local v3    # "oldCursor":Landroid/database/Cursor;
    :cond_2
    return-object v0
.end method
