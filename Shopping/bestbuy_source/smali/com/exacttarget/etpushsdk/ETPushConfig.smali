.class public Lcom/exacttarget/etpushsdk/ETPushConfig;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field protected final a:Landroid/app/Application;

.field protected b:Ljava/lang/String;

.field protected c:Ljava/lang/String;

.field protected d:Ljava/lang/String;

.field protected e:Z

.field protected f:Z

.field protected g:Z

.field protected h:Z

.field protected i:Z

.field protected j:Ljava/lang/Class;

.field protected k:Ljava/lang/Class;

.field protected l:Ljava/lang/Class;

.field protected m:Ljava/lang/String;

.field protected n:Landroid/net/Uri;

.field protected o:I

.field protected p:I


# direct methods
.method private constructor <init>(Landroid/app/Application;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->e:Z

    .line 20
    iput-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->f:Z

    .line 21
    iput-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->g:Z

    .line 22
    iput-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->h:Z

    .line 23
    iput-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->i:Z

    .line 29
    const/4 v0, 0x5

    iput v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->o:I

    .line 32
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->a:Landroid/app/Application;

    .line 33
    return-void
.end method

.method synthetic constructor <init>(Landroid/app/Application;Lcom/exacttarget/etpushsdk/ETPushConfig$1;)V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPushConfig;-><init>(Landroid/app/Application;)V

    return-void
.end method
