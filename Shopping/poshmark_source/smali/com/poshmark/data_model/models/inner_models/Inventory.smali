.class public Lcom/poshmark/data_model/models/inner_models/Inventory;
.super Ljava/lang/Object;
.source "Inventory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    }
.end annotation


# instance fields
.field public caller_has_reserved:Ljava/lang/Boolean;

.field public count:Ljava/lang/String;

.field public last_unit_reserved_at:Ljava/lang/String;

.field public status:Ljava/lang/String;

.field public status_changed_at:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->caller_has_reserved:Ljava/lang/Boolean;

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/Inventory;)V
    .locals 1
    .param p1, "inventory"    # Lcom/poshmark/data_model/models/inner_models/Inventory;

    .prologue
    .line 19
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Inventory;->count:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->count:Ljava/lang/String;

    .line 20
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Inventory;->status:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->status:Ljava/lang/String;

    .line 21
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Inventory;->status_changed_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->status_changed_at:Ljava/lang/String;

    .line 22
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Inventory;->last_unit_reserved_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->last_unit_reserved_at:Ljava/lang/String;

    .line 23
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Inventory;->caller_has_reserved:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->caller_has_reserved:Ljava/lang/Boolean;

    .line 24
    return-void
.end method

.method public getInventoryStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    .locals 3

    .prologue
    .line 28
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .line 30
    .local v0, "statusType":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->status:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "available"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 31
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .line 39
    :cond_0
    :goto_0
    return-object v0

    .line 32
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->status:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "not_available"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 33
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    goto :goto_0

    .line 34
    :cond_2
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->status:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "sold_out"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 35
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    goto :goto_0

    .line 36
    :cond_3
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Inventory;->status:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "not_for_sale"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 37
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->NOT_FOR_SALE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    goto :goto_0
.end method
