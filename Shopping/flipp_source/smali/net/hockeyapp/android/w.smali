.class final Lnet/hockeyapp/android/w;
.super Lnet/hockeyapp/android/b/a;
.source "SourceFile"


# instance fields
.field final synthetic a:Landroid/app/Activity;

.field final synthetic b:Lnet/hockeyapp/android/v;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/v;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lnet/hockeyapp/android/w;->b:Lnet/hockeyapp/android/v;

    iput-object p2, p0, Lnet/hockeyapp/android/w;->a:Landroid/app/Activity;

    invoke-direct {p0}, Lnet/hockeyapp/android/b/a;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 176
    invoke-static {}, Lnet/hockeyapp/android/y;->b()Lnet/hockeyapp/android/z;

    move-result-object v0

    .line 177
    if-eqz v0, :cond_0

    .line 178
    invoke-virtual {v0, p1}, Lnet/hockeyapp/android/z;->a(I)Ljava/lang/String;

    move-result-object v0

    .line 181
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final a()V
    .locals 0

    .prologue
    .line 173
    return-void
.end method

.method public final a(Ljava/lang/Boolean;)V
    .locals 2

    .prologue
    .line 166
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Lnet/hockeyapp/android/w;->b:Lnet/hockeyapp/android/v;

    iget-object v1, p0, Lnet/hockeyapp/android/w;->a:Landroid/app/Activity;

    # invokes: Lnet/hockeyapp/android/v;->startDownloadTask(Landroid/app/Activity;)V
    invoke-static {v0, v1}, Lnet/hockeyapp/android/v;->access$000(Lnet/hockeyapp/android/v;Landroid/app/Activity;)V

    .line 169
    :cond_0
    return-void
.end method
