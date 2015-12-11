.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private appointmentId:Ljava/lang/String;

.field private appointmentSlots:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;",
            ">;"
        }
    .end annotation
.end field

.field private bookABlueShirt:Z

.field private bookABlueShirtStores:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private chat:Z

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private recommendations:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

.field private skuList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppointmentId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->appointmentId:Ljava/lang/String;

    return-object v0
.end method

.method public getAppointmentSlots()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->appointmentSlots:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getBookABlueShirtStores()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->bookABlueShirtStores:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getRecommendations()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->recommendations:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    return-object v0
.end method

.method public getSkuList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->skuList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public isBookABlueShirt()Z
    .locals 1

    .prologue
    .line 54
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->bookABlueShirt:Z

    return v0
.end method

.method public isChat()Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->chat:Z

    return v0
.end method

.method public setAppointmentId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->appointmentId:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setAppointmentSlots(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->appointmentSlots:Ljava/util/ArrayList;

    .line 51
    return-void
.end method

.method public setBookABlueShirt(Z)V
    .locals 0

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->bookABlueShirt:Z

    .line 59
    return-void
.end method

.method public setBookABlueShirtStores(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->bookABlueShirtStores:Ljava/util/ArrayList;

    .line 75
    return-void
.end method

.method public setChat(Z)V
    .locals 0

    .prologue
    .line 66
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->chat:Z

    .line 67
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 85
    return-void
.end method

.method public setRecommendations(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->recommendations:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    .line 106
    return-void
.end method

.method public setSkuList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 97
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->skuList:Ljava/util/ArrayList;

    .line 98
    return-void
.end method
