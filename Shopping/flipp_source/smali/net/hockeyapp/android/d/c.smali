.class final Lnet/hockeyapp/android/d/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lorg/json/JSONArray;

.field final synthetic b:Lnet/hockeyapp/android/d/a;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/d/a;Lorg/json/JSONArray;)V
    .locals 0

    .prologue
    .line 303
    iput-object p1, p0, Lnet/hockeyapp/android/d/c;->b:Lnet/hockeyapp/android/d/a;

    iput-object p2, p0, Lnet/hockeyapp/android/d/c;->a:Lorg/json/JSONArray;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 305
    iget-object v0, p0, Lnet/hockeyapp/android/d/c;->b:Lnet/hockeyapp/android/d/a;

    invoke-static {v0}, Lnet/hockeyapp/android/d/a;->b(Lnet/hockeyapp/android/d/a;)Landroid/app/Activity;

    move-result-object v0

    const-string v1, "[]"

    invoke-static {v0, v1}, Lnet/hockeyapp/android/e/h;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 309
    new-instance v0, Ljava/lang/ref/WeakReference;

    iget-object v1, p0, Lnet/hockeyapp/android/d/c;->b:Lnet/hockeyapp/android/d/a;

    invoke-static {v1}, Lnet/hockeyapp/android/d/a;->b(Lnet/hockeyapp/android/d/a;)Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 310
    invoke-static {}, Lnet/hockeyapp/android/y;->a()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {v0}, Lnet/hockeyapp/android/y;->a(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 311
    iget-object v0, p0, Lnet/hockeyapp/android/d/c;->b:Lnet/hockeyapp/android/d/a;

    iget-object v1, p0, Lnet/hockeyapp/android/d/c;->a:Lorg/json/JSONArray;

    invoke-static {v0, v1}, Lnet/hockeyapp/android/d/a;->a(Lnet/hockeyapp/android/d/a;Lorg/json/JSONArray;)V

    .line 316
    :goto_0
    return-void

    .line 314
    :cond_0
    iget-object v0, p0, Lnet/hockeyapp/android/d/c;->b:Lnet/hockeyapp/android/d/a;

    iget-object v1, p0, Lnet/hockeyapp/android/d/c;->a:Lorg/json/JSONArray;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lnet/hockeyapp/android/d/a;->a(Lnet/hockeyapp/android/d/a;Lorg/json/JSONArray;Ljava/lang/Boolean;)V

    goto :goto_0
.end method
