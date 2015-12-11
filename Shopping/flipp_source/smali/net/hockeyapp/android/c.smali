.class final Lnet/hockeyapp/android/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lnet/hockeyapp/android/g;

.field final synthetic b:Ljava/lang/ref/WeakReference;

.field final synthetic c:Z


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/g;Ljava/lang/ref/WeakReference;Z)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lnet/hockeyapp/android/c;->a:Lnet/hockeyapp/android/g;

    iput-object p2, p0, Lnet/hockeyapp/android/c;->b:Ljava/lang/ref/WeakReference;

    iput-boolean p3, p0, Lnet/hockeyapp/android/c;->c:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 366
    iget-object v0, p0, Lnet/hockeyapp/android/c;->b:Ljava/lang/ref/WeakReference;

    invoke-static {v0}, Lnet/hockeyapp/android/b;->a(Ljava/lang/ref/WeakReference;)V

    .line 371
    iget-object v0, p0, Lnet/hockeyapp/android/c;->a:Lnet/hockeyapp/android/g;

    iget-boolean v1, p0, Lnet/hockeyapp/android/c;->c:Z

    invoke-static {v0, v1}, Lnet/hockeyapp/android/b;->a(Lnet/hockeyapp/android/g;Z)V

    .line 372
    return-void
.end method
