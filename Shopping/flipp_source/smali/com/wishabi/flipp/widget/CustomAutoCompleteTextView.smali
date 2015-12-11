.class public Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;
.super Landroid/widget/AutoCompleteTextView;
.source "SourceFile"


# static fields
.field static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/wishabi/flipp/widget/au;

.field private c:Landroid/widget/SimpleCursorAdapter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0, p1}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;)V

    .line 36
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->a()V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->a()V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 47
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->a()V

    .line 48
    return-void
.end method

.method private a()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 51
    new-instance v0, Landroid/widget/SimpleCursorAdapter;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x109000a

    const/4 v3, 0x0

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "suggest_intent_query"

    aput-object v5, v4, v6

    new-array v5, v7, [I

    const v7, 0x1020014

    aput v7, v5, v6

    invoke-direct/range {v0 .. v6}, Landroid/widget/SimpleCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->c:Landroid/widget/SimpleCursorAdapter;

    .line 56
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->c:Landroid/widget/SimpleCursorAdapter;

    new-instance v1, Lcom/wishabi/flipp/widget/as;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/as;-><init>(Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;)V

    invoke-virtual {v0, v1}, Landroid/widget/SimpleCursorAdapter;->setFilterQueryProvider(Landroid/widget/FilterQueryProvider;)V

    .line 77
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->c:Landroid/widget/SimpleCursorAdapter;

    new-instance v1, Lcom/wishabi/flipp/widget/at;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/at;-><init>(Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;)V

    invoke-virtual {v0, v1}, Landroid/widget/SimpleCursorAdapter;->setCursorToStringConverter(Landroid/widget/SimpleCursorAdapter$CursorToStringConverter;)V

    .line 85
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->c:Landroid/widget/SimpleCursorAdapter;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 86
    return-void
.end method


# virtual methods
.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .locals 2

    .prologue
    .line 94
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->b:Lcom/wishabi/flipp/widget/au;

    if-eqz v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->b:Lcom/wishabi/flipp/widget/au;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/widget/au;->a(Landroid/widget/EditText;)V

    .line 98
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/AutoCompleteTextView;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public setKeyboardDimissedListener(Lcom/wishabi/flipp/widget/au;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CustomAutoCompleteTextView;->b:Lcom/wishabi/flipp/widget/au;

    .line 90
    return-void
.end method
