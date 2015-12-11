.class final Lml;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/hardware/Camera$PreviewCallback;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private final b:Lmi;

.field private final c:Z

.field private d:Landroid/os/Handler;

.field private e:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lml;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lml;->a:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Lmi;Z)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lml;->b:Lmi;

    .line 35
    iput-boolean p2, p0, Lml;->c:Z

    .line 36
    return-void
.end method


# virtual methods
.method a(Landroid/os/Handler;I)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lml;->d:Landroid/os/Handler;

    .line 40
    iput p2, p0, Lml;->e:I

    .line 41
    return-void
.end method

.method public onPreviewFrame([BLandroid/hardware/Camera;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 44
    iget-object v0, p0, Lml;->b:Lmi;

    invoke-virtual {v0}, Lmi;->a()Landroid/graphics/Point;

    move-result-object v0

    .line 45
    iget-boolean v1, p0, Lml;->c:Z

    if-nez v1, :cond_0

    .line 46
    invoke-virtual {p2, v4}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    .line 48
    :cond_0
    iget-object v1, p0, Lml;->d:Landroid/os/Handler;

    if-eqz v1, :cond_1

    .line 49
    iget-object v1, p0, Lml;->d:Landroid/os/Handler;

    iget v2, p0, Lml;->e:I

    iget v3, v0, Landroid/graphics/Point;->x:I

    iget v0, v0, Landroid/graphics/Point;->y:I

    invoke-virtual {v1, v2, v3, v0, p1}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 50
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 51
    iput-object v4, p0, Lml;->d:Landroid/os/Handler;

    .line 55
    :cond_1
    return-void
.end method
