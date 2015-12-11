.class public Lcom/exacttarget/etpushsdk/util/l;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/Double;

.field private b:Ljava/lang/Double;


# direct methods
.method public constructor <init>(Ljava/lang/Double;Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/util/l;->a:Ljava/lang/Double;

    .line 18
    iput-object p2, p0, Lcom/exacttarget/etpushsdk/util/l;->b:Ljava/lang/Double;

    .line 19
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/l;->a:Ljava/lang/Double;

    return-object v0
.end method

.method public b()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/l;->b:Ljava/lang/Double;

    return-object v0
.end method
