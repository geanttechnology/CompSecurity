.class public Lcom/amazon/communication/ir/IRServiceEndpointImpl;
.super Ljava/lang/Object;
.source "IRServiceEndpointImpl.java"

# interfaces
.implements Lamazon/communication/identity/IRServiceEndpoint;


# static fields
.field private static final WHITE_LISTED_DOMAINS:[Ljava/lang/String;

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

.field private final mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

.field private final mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

.field private final mDomain:Ljava/lang/String;

.field private final mHostname:Ljava/lang/String;

.field private final mPort:Ljava/lang/Integer;

.field private final mRealm:Ljava/lang/String;

.field private final mSecurePort:Ljava/lang/Integer;

.field private final mTimeout:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 28
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.IRServiceEndpointImpl"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->log:Lcom/amazon/dp/logger/DPLogger;

    .line 30
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, ".amazon.com"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, ".amazon.co.uk"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->WHITE_LISTED_DOMAINS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;Lamazon/communication/identity/IRServiceEndpoint$DataCompression;Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;ILjava/lang/Integer;Ljava/lang/Integer;)V
    .locals 0
    .param p1, "hostname"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "realm"    # Ljava/lang/String;
    .param p4, "directConnection"    # Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;
    .param p5, "dataCompression"    # Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
    .param p6, "clearTextConnection"    # Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;
    .param p7, "timeout"    # I
    .param p8, "port"    # Ljava/lang/Integer;
    .param p9, "securePort"    # Ljava/lang/Integer;

    .prologue
    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    iput-object p1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    .line 96
    iput-object p2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    .line 97
    iput-object p3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    .line 98
    iput p7, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mTimeout:I

    .line 99
    iput-object p4, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    .line 100
    iput-object p5, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    .line 101
    iput-object p6, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    .line 102
    iput-object p8, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    .line 103
    iput-object p9, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    .line 104
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 162
    if-ne p1, p0, :cond_1

    .line 231
    :cond_0
    :goto_0
    return v1

    .line 164
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 165
    goto :goto_0

    .line 167
    :cond_2
    instance-of v3, p1, Lamazon/communication/identity/IRServiceEndpoint;

    if-eqz v3, :cond_13

    move-object v0, p1

    .line 168
    check-cast v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;

    .line 169
    .local v0, "other":Lcom/amazon/communication/ir/IRServiceEndpointImpl;
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    if-nez v3, :cond_3

    .line 170
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    if-eqz v3, :cond_4

    move v1, v2

    .line 171
    goto :goto_0

    .line 173
    :cond_3
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 174
    goto :goto_0

    .line 176
    :cond_4
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    if-nez v3, :cond_5

    .line 177
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    if-eqz v3, :cond_6

    move v1, v2

    .line 178
    goto :goto_0

    .line 180
    :cond_5
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    move v1, v2

    .line 181
    goto :goto_0

    .line 183
    :cond_6
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    if-nez v3, :cond_7

    .line 184
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    if-eqz v3, :cond_8

    move v1, v2

    .line 185
    goto :goto_0

    .line 187
    :cond_7
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_8

    move v1, v2

    .line 188
    goto :goto_0

    .line 190
    :cond_8
    iget v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mTimeout:I

    iget v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mTimeout:I

    if-eq v3, v4, :cond_9

    move v1, v2

    .line 191
    goto :goto_0

    .line 193
    :cond_9
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    if-nez v3, :cond_a

    .line 194
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    if-eqz v3, :cond_b

    move v1, v2

    .line 195
    goto :goto_0

    .line 197
    :cond_a
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    invoke-virtual {v3, v4}, Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_b

    move v1, v2

    .line 198
    goto :goto_0

    .line 200
    :cond_b
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    if-nez v3, :cond_c

    .line 201
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    if-eqz v3, :cond_d

    move v1, v2

    .line 202
    goto :goto_0

    .line 204
    :cond_c
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    invoke-virtual {v3, v4}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_d

    move v1, v2

    .line 205
    goto/16 :goto_0

    .line 207
    :cond_d
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    if-nez v3, :cond_e

    .line 208
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    if-eqz v3, :cond_f

    move v1, v2

    .line 209
    goto/16 :goto_0

    .line 211
    :cond_e
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    invoke-virtual {v3, v4}, Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_f

    move v1, v2

    .line 212
    goto/16 :goto_0

    .line 214
    :cond_f
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    if-nez v3, :cond_10

    .line 215
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    if-eqz v3, :cond_11

    move v1, v2

    .line 216
    goto/16 :goto_0

    .line 218
    :cond_10
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    invoke-virtual {v3, v4}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_11

    move v1, v2

    .line 219
    goto/16 :goto_0

    .line 221
    :cond_11
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    if-nez v3, :cond_12

    .line 222
    iget-object v3, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    if-eqz v3, :cond_0

    move v1, v2

    .line 223
    goto/16 :goto_0

    .line 225
    :cond_12
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    iget-object v4, v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    invoke-virtual {v3, v4}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 226
    goto/16 :goto_0

    .end local v0    # "other":Lcom/amazon/communication/ir/IRServiceEndpointImpl;
    :cond_13
    move v1, v2

    .line 231
    goto/16 :goto_0
.end method

.method public getClearTextConnection()Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    return-object v0
.end method

.method public getDataCompression()Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    return-object v0
.end method

.method public getDirectConnection()Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    return-object v0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    return-object v0
.end method

.method public getHostname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    return-object v0
.end method

.method public getPort()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    return-object v0
.end method

.method public getRealm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    return-object v0
.end method

.method public getSecurePort()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    return-object v0
.end method

.method public getTimeout()I
    .locals 1

    .prologue
    .line 138
    iget v0, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mTimeout:I

    return v0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 237
    const/16 v0, 0x25

    .line 238
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 239
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    if-nez v2, :cond_0

    move v2, v3

    :goto_0
    add-int/lit8 v1, v2, 0x25

    .line 240
    mul-int/lit8 v4, v1, 0x25

    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    if-nez v2, :cond_1

    move v2, v3

    :goto_1
    add-int v1, v4, v2

    .line 241
    mul-int/lit8 v4, v1, 0x25

    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    if-nez v2, :cond_2

    move v2, v3

    :goto_2
    add-int v1, v4, v2

    .line 242
    mul-int/lit8 v2, v1, 0x25

    iget v4, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mTimeout:I

    add-int v1, v2, v4

    .line 243
    mul-int/lit8 v4, v1, 0x25

    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    if-nez v2, :cond_3

    move v2, v3

    :goto_3
    add-int v1, v4, v2

    .line 244
    mul-int/lit8 v4, v1, 0x25

    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    if-nez v2, :cond_4

    move v2, v3

    :goto_4
    add-int v1, v4, v2

    .line 245
    mul-int/lit8 v4, v1, 0x25

    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    if-nez v2, :cond_5

    move v2, v3

    :goto_5
    add-int v1, v4, v2

    .line 246
    mul-int/lit8 v4, v1, 0x25

    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    if-nez v2, :cond_6

    move v2, v3

    :goto_6
    add-int v1, v4, v2

    .line 247
    mul-int/lit8 v2, v1, 0x25

    iget-object v4, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    if-nez v4, :cond_7

    :goto_7
    add-int v1, v2, v3

    .line 248
    return v1

    .line 239
    :cond_0
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_0

    .line 240
    :cond_1
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_1

    .line 241
    :cond_2
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_2

    .line 243
    :cond_3
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    invoke-virtual {v2}, Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;->hashCode()I

    move-result v2

    goto :goto_3

    .line 244
    :cond_4
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    invoke-virtual {v2}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->hashCode()I

    move-result v2

    goto :goto_4

    .line 245
    :cond_5
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    invoke-virtual {v2}, Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;->hashCode()I

    move-result v2

    goto :goto_5

    .line 246
    :cond_6
    iget-object v2, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mPort:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    goto :goto_6

    .line 247
    :cond_7
    iget-object v3, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mSecurePort:Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    goto :goto_7
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 153
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "Service Endpoint on domain: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDomain:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mRealm:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mHostname:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " - Direct connection "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDirectConnection:Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", - Data compression "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mDataCompression:Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", - Clear text connection "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mClearTextConnection:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;->mTimeout:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " timeout"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
