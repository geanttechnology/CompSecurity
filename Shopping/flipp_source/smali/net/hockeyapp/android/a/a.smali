.class public final Lnet/hockeyapp/android/a/a;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"


# instance fields
.field public a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lnet/hockeyapp/android/c/c;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/content/Context;

.field private c:Ljava/text/SimpleDateFormat;

.field private d:Ljava/text/SimpleDateFormat;

.field private e:Ljava/util/Date;

.field private f:Landroid/widget/TextView;

.field private g:Landroid/widget/TextView;

.field private h:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Lnet/hockeyapp/android/c/c;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 27
    iput-object p1, p0, Lnet/hockeyapp/android/a/a;->b:Landroid/content/Context;

    .line 28
    iput-object p2, p0, Lnet/hockeyapp/android/a/a;->a:Ljava/util/ArrayList;

    .line 30
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lnet/hockeyapp/android/a/a;->c:Ljava/text/SimpleDateFormat;

    .line 31
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "d MMM h:mm a"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lnet/hockeyapp/android/a/a;->d:Ljava/text/SimpleDateFormat;

    .line 32
    return-void
.end method


# virtual methods
.method public final getCount()I
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lnet/hockeyapp/android/a/a;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public final getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lnet/hockeyapp/android/a/a;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getItemId(I)J
    .locals 2

    .prologue
    .line 78
    int-to-long v0, p1

    return-wide v0
.end method

.method public final getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4

    .prologue
    .line 40
    iget-object v0, p0, Lnet/hockeyapp/android/a/a;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/hockeyapp/android/c/c;

    .line 43
    if-nez p2, :cond_1

    .line 44
    new-instance p2, Lnet/hockeyapp/android/f/a;

    iget-object v1, p0, Lnet/hockeyapp/android/a/a;->b:Landroid/content/Context;

    invoke-direct {p2, v1}, Lnet/hockeyapp/android/f/a;-><init>(Landroid/content/Context;)V

    .line 50
    :goto_0
    if-eqz v0, :cond_0

    .line 51
    const/16 v1, 0x3001

    invoke-virtual {p2, v1}, Lnet/hockeyapp/android/f/a;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lnet/hockeyapp/android/a/a;->f:Landroid/widget/TextView;

    .line 52
    const/16 v1, 0x3002

    invoke-virtual {p2, v1}, Lnet/hockeyapp/android/f/a;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lnet/hockeyapp/android/a/a;->g:Landroid/widget/TextView;

    .line 53
    const/16 v1, 0x3003

    invoke-virtual {p2, v1}, Lnet/hockeyapp/android/f/a;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lnet/hockeyapp/android/a/a;->h:Landroid/widget/TextView;

    .line 56
    :try_start_0
    iget-object v1, p0, Lnet/hockeyapp/android/a/a;->c:Ljava/text/SimpleDateFormat;

    iget-object v2, v0, Lnet/hockeyapp/android/c/c;->f:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    iput-object v1, p0, Lnet/hockeyapp/android/a/a;->e:Ljava/util/Date;

    .line 57
    iget-object v1, p0, Lnet/hockeyapp/android/a/a;->g:Landroid/widget/TextView;

    iget-object v2, p0, Lnet/hockeyapp/android/a/a;->d:Ljava/text/SimpleDateFormat;

    iget-object v3, p0, Lnet/hockeyapp/android/a/a;->e:Ljava/util/Date;

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    :goto_1
    iget-object v1, p0, Lnet/hockeyapp/android/a/a;->f:Landroid/widget/TextView;

    iget-object v2, v0, Lnet/hockeyapp/android/c/c;->l:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    iget-object v1, p0, Lnet/hockeyapp/android/a/a;->h:Landroid/widget/TextView;

    iget-object v0, v0, Lnet/hockeyapp/android/c/c;->b:Ljava/lang/String;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    :cond_0
    rem-int/lit8 v0, p1, 0x2

    if-nez v0, :cond_2

    const/4 v0, 0x0

    :goto_2
    invoke-virtual {p2, v0}, Lnet/hockeyapp/android/f/a;->setFeedbackMessageViewBgAndTextColor(I)V

    .line 68
    return-object p2

    .line 47
    :cond_1
    check-cast p2, Lnet/hockeyapp/android/f/a;

    goto :goto_0

    .line 58
    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/text/ParseException;->printStackTrace()V

    goto :goto_1

    .line 66
    :cond_2
    const/4 v0, 0x1

    goto :goto_2
.end method
