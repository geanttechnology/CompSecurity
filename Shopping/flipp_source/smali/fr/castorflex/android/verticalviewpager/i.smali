.class final Lfr/castorflex/android/verticalviewpager/i;
.super Landroid/database/DataSetObserver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;


# direct methods
.method private constructor <init>(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)V
    .locals 0

    .prologue
    .line 2714
    iput-object p1, p0, Lfr/castorflex/android/verticalviewpager/i;->a:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;B)V
    .locals 0

    .prologue
    .line 2714
    invoke-direct {p0, p1}, Lfr/castorflex/android/verticalviewpager/i;-><init>(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)V

    return-void
.end method


# virtual methods
.method public final onChanged()V
    .locals 1

    .prologue
    .line 2717
    iget-object v0, p0, Lfr/castorflex/android/verticalviewpager/i;->a:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v0}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->a()V

    .line 2718
    return-void
.end method

.method public final onInvalidated()V
    .locals 1

    .prologue
    .line 2722
    iget-object v0, p0, Lfr/castorflex/android/verticalviewpager/i;->a:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v0}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->a()V

    .line 2723
    return-void
.end method
