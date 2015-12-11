.class final Lnet/hockeyapp/android/d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Ljava/lang/ref/WeakReference;

.field final synthetic b:Lnet/hockeyapp/android/g;

.field final synthetic c:Z


# direct methods
.method constructor <init>(Ljava/lang/ref/WeakReference;Lnet/hockeyapp/android/g;Z)V
    .locals 0

    .prologue
    .line 375
    iput-object p1, p0, Lnet/hockeyapp/android/d;->a:Ljava/lang/ref/WeakReference;

    iput-object p2, p0, Lnet/hockeyapp/android/d;->b:Lnet/hockeyapp/android/g;

    iput-boolean p3, p0, Lnet/hockeyapp/android/d;->c:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 377
    iget-object v0, p0, Lnet/hockeyapp/android/d;->a:Ljava/lang/ref/WeakReference;

    iget-object v1, p0, Lnet/hockeyapp/android/d;->b:Lnet/hockeyapp/android/g;

    iget-boolean v2, p0, Lnet/hockeyapp/android/d;->c:Z

    invoke-static {v0, v1, v2}, Lnet/hockeyapp/android/b;->a(Ljava/lang/ref/WeakReference;Lnet/hockeyapp/android/g;Z)V

    .line 378
    return-void
.end method
