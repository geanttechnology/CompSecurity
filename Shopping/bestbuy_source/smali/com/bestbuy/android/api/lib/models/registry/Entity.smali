.class public Lcom/bestbuy/android/api/lib/models/registry/Entity;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private activated:Ljava/lang/String;

.field private certTotalAvailableValue:Ljava/lang/String;

.field private created:Ljava/lang/String;

.field private expires_in:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private invalidLogins:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private locked:Ljava/lang/String;

.field private lockedAt:Ljava/lang/String;

.field private modified:Ljava/lang/String;

.field private pointsBalance:Ljava/lang/String;

.field private postalCode:Ljava/lang/String;

.field private rzLinkStatus:Ljava/lang/String;

.field private rzMemberId:Ljava/lang/String;

.field private rzStatus:Ljava/lang/String;

.field private rzTierStatus:Ljava/lang/String;

.field private rzTotalCerts:Ljava/lang/String;

.field private rzTotalPoints:Ljava/lang/String;

.field private transientValue:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "transient"
    .end annotation
.end field

.field private type:Ljava/lang/String;

.field private username:Ljava/lang/String;

.field private uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getActivated()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->activated:Ljava/lang/String;

    return-object v0
.end method

.method public getCertTotalAvailableValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->certTotalAvailableValue:Ljava/lang/String;

    return-object v0
.end method

.method public getCreated()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->created:Ljava/lang/String;

    return-object v0
.end method

.method public getExpires_in()Ljava/lang/String;
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->expires_in:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->firstName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->firstName:Ljava/lang/String;

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->firstName:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v0

    .line 130
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->firstName:Ljava/lang/String;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getInvalidLogins()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->invalidLogins:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->lastName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->lastName:Ljava/lang/String;

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->lastName:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v0

    .line 144
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->lastName:Ljava/lang/String;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLocked()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->locked:Ljava/lang/String;

    return-object v0
.end method

.method public getLockedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->lockedAt:Ljava/lang/String;

    return-object v0
.end method

.method public getModified()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->modified:Ljava/lang/String;

    return-object v0
.end method

.method public getPointsBalance()Ljava/lang/String;
    .locals 1

    .prologue
    .line 278
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->pointsBalance:Ljava/lang/String;

    return-object v0
.end method

.method public getPostalCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->postalCode:Ljava/lang/String;

    return-object v0
.end method

.method public getRzLinkStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzLinkStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getRzMemberId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzMemberId:Ljava/lang/String;

    return-object v0
.end method

.method public getRzStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getRzTierStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzTierStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getRzTotalCerts()Ljava/lang/String;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzTotalCerts:Ljava/lang/String;

    return-object v0
.end method

.method public getRzTotalPoints()Ljava/lang/String;
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzTotalPoints:Ljava/lang/String;

    return-object v0
.end method

.method public getTransientValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->transientValue:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->username:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public setActivated(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->activated:Ljava/lang/String;

    .line 99
    return-void
.end method

.method public setCertTotalAvailableValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 271
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->certTotalAvailableValue:Ljava/lang/String;

    .line 272
    return-void
.end method

.method public setCreated(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->created:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setExpires_in(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 234
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->expires_in:Ljava/lang/String;

    .line 235
    return-void
.end method

.method public setFirstName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->firstName:Ljava/lang/String;

    .line 137
    return-void
.end method

.method public setInvalidLogins(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->invalidLogins:Ljava/lang/String;

    .line 123
    return-void
.end method

.method public setLastName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->lastName:Ljava/lang/String;

    .line 151
    return-void
.end method

.method public setLocked(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->locked:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setLockedAt(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->lockedAt:Ljava/lang/String;

    .line 163
    return-void
.end method

.method public setModified(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->modified:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public setPointsBalance(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->pointsBalance:Ljava/lang/String;

    .line 285
    return-void
.end method

.method public setPostalCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->postalCode:Ljava/lang/String;

    .line 175
    return-void
.end method

.method public setRzLinkStatus(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 186
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzLinkStatus:Ljava/lang/String;

    .line 187
    return-void
.end method

.method public setRzMemberId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 198
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzMemberId:Ljava/lang/String;

    .line 199
    return-void
.end method

.method public setRzStatus(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 210
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzStatus:Ljava/lang/String;

    .line 211
    return-void
.end method

.method public setRzTierStatus(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzTierStatus:Ljava/lang/String;

    .line 223
    return-void
.end method

.method public setRzTotalCerts(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 258
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzTotalCerts:Ljava/lang/String;

    .line 259
    return-void
.end method

.method public setRzTotalPoints(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->rzTotalPoints:Ljava/lang/String;

    .line 247
    return-void
.end method

.method public setTransientValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 309
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->transientValue:Ljava/lang/String;

    .line 310
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->type:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->username:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setUuid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entity;->uuid:Ljava/lang/String;

    .line 297
    return-void
.end method
