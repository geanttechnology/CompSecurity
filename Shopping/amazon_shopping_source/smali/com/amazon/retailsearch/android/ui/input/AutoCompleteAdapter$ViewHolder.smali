.class Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "AutoCompleteAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ViewHolder"
.end annotation


# instance fields
.field textView:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;->this$0:Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$1;

    .prologue
    .line 152
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;-><init>(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)V

    return-void
.end method
