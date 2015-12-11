.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;
.super Ljava/lang/Object;
.source "RetailSearchEditTextWatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FilterResultValue"
.end annotation


# instance fields
.field public mCursor:Landroid/database/Cursor;

.field public mSearchTerm:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Landroid/database/Cursor;Ljava/lang/String;)V
    .locals 0
    .param p2, "c"    # Landroid/database/Cursor;
    .param p3, "s"    # Ljava/lang/String;

    .prologue
    .line 581
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 582
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;->mCursor:Landroid/database/Cursor;

    .line 583
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;->mSearchTerm:Ljava/lang/String;

    .line 584
    return-void
.end method
