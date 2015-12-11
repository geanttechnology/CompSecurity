.class public Lcom/bestbuy/android/api/lib/models/remix/StoreHours;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private close:Ljava/lang/String;

.field private date:Ljava/lang/String;

.field private day:Ljava/lang/String;

.field private open:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getClose()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->close:Ljava/lang/String;

    return-object v0
.end method

.method public getDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->date:Ljava/lang/String;

    return-object v0
.end method

.method public getDay()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->day:Ljava/lang/String;

    return-object v0
.end method

.method public getOpen()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->open:Ljava/lang/String;

    return-object v0
.end method

.method public setClose(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->close:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->date:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setDay(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 19
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->day:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public setOpen(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/remix/StoreHours;->open:Ljava/lang/String;

    .line 36
    return-void
.end method
