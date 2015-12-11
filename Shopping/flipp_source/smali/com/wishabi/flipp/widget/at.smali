.class final Lcom/wishabi/flipp/widget/at;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/wishabi/flipp/widget/at;->a:Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 80
    const-string v0, "suggest_intent_query"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 81
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
