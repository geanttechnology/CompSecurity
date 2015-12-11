.class public Lcom/poshmark/utils/TextValidator;
.super Ljava/lang/Object;
.source "TextValidator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/TextValidator$1;,
        Lcom/poshmark/utils/TextValidator$MODE;
    }
.end annotation


# instance fields
.field validatorMode:Lcom/poshmark/utils/TextValidator$MODE;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE:Lcom/poshmark/utils/TextValidator$MODE;

    iput-object v0, p0, Lcom/poshmark/utils/TextValidator;->validatorMode:Lcom/poshmark/utils/TextValidator$MODE;

    .line 16
    return-void
.end method

.method private validateCreditCardNumber(Ljava/lang/String;)Z
    .locals 2
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    .line 110
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xc

    if-lt v0, v1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x13

    if-le v0, v1, :cond_1

    .line 111
    :cond_0
    const/4 v0, 0x0

    .line 113
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private validateEmail(Ljava/lang/String;)Z
    .locals 1
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    .line 71
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "@"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 72
    :cond_0
    const/4 v0, 0x0

    .line 75
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private validatePassword(Ljava/lang/String;)Z
    .locals 2
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    .line 80
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x6

    if-lt v0, v1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x18

    if-le v0, v1, :cond_1

    .line 81
    :cond_0
    const/4 v0, 0x0

    .line 84
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private validateSimple(Ljava/lang/String;)Z
    .locals 1
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    .line 89
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 90
    const/4 v0, 0x0

    .line 92
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private validateSimpleNoSpaces(Ljava/lang/String;)Z
    .locals 3
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 97
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 104
    :cond_0
    :goto_0
    return v1

    .line 100
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, "stripped":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 102
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private validateUsername(Ljava/lang/String;)Z
    .locals 2
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    .line 62
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x3

    if-ge v0, v1, :cond_1

    .line 63
    :cond_0
    const/4 v0, 0x0

    .line 66
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private validateZipcode(Ljava/lang/String;)Z
    .locals 2
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    .line 117
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x5

    if-ge v0, v1, :cond_1

    .line 118
    :cond_0
    const/4 v0, 0x0

    .line 120
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "string"    # Ljava/lang/String;

    .prologue
    .line 181
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 182
    .local v0, "errorMessage":Ljava/lang/String;
    sget-object v6, Lcom/poshmark/utils/TextValidator$1;->$SwitchMap$com$poshmark$utils$TextValidator$MODE:[I

    iget-object v7, p0, Lcom/poshmark/utils/TextValidator;->validatorMode:Lcom/poshmark/utils/TextValidator$MODE;

    invoke-virtual {v7}, Lcom/poshmark/utils/TextValidator$MODE;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 231
    :cond_0
    :goto_0
    :pswitch_0
    return-object v0

    .line 188
    :pswitch_1
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v6

    const/4 v7, 0x6

    if-ge v6, v7, :cond_1

    .line 189
    const v6, 0x7f0601c8

    invoke-virtual {p1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 191
    :cond_1
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v6

    const/16 v7, 0x18

    if-le v6, v7, :cond_0

    .line 192
    const v6, 0x7f0601c7

    invoke-virtual {p1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 196
    :pswitch_2
    const-string v4, "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"

    .line 202
    .local v4, "regExpn":Ljava/lang/String;
    move-object v1, p2

    .line 203
    .local v1, "inputStr":Ljava/lang/CharSequence;
    const/4 v6, 0x2

    invoke-static {v4, v6}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v3

    .line 204
    .local v3, "pattern":Ljava/util/regex/Pattern;
    invoke-virtual {v3, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 205
    .local v2, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v6

    if-nez v6, :cond_0

    .line 206
    const v6, 0x7f060277

    invoke-virtual {p1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 217
    .end local v1    # "inputStr":Ljava/lang/CharSequence;
    .end local v2    # "matcher":Ljava/util/regex/Matcher;
    .end local v3    # "pattern":Ljava/util/regex/Pattern;
    .end local v4    # "regExpn":Ljava/lang/String;
    :pswitch_3
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v6

    const/4 v7, 0x3

    if-ge v6, v7, :cond_3

    .line 218
    const v6, 0x7f06027a

    invoke-virtual {p1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 224
    :cond_2
    :goto_1
    const-string v5, "^[a-zA-Z0-9]*$"

    .line 225
    .local v5, "regex":Ljava/lang/String;
    invoke-virtual {p2, v5}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 226
    const v6, 0x7f06027b

    invoke-virtual {p1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 220
    .end local v5    # "regex":Ljava/lang/String;
    :cond_3
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v6

    const/16 v7, 0xf

    if-le v6, v7, :cond_2

    .line 221
    const v6, 0x7f06027c

    invoke-virtual {p1, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 182
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public isValid(Ljava/lang/String;)Z
    .locals 3
    .param p1, "srcString"    # Ljava/lang/String;

    .prologue
    .line 23
    const/4 v0, 0x0

    .line 24
    .local v0, "retVal":Z
    sget-object v1, Lcom/poshmark/utils/TextValidator$1;->$SwitchMap$com$poshmark$utils$TextValidator$MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/TextValidator;->validatorMode:Lcom/poshmark/utils/TextValidator$MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/TextValidator$MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 58
    :goto_0
    return v0

    .line 27
    :pswitch_0
    invoke-direct {p0, p1}, Lcom/poshmark/utils/TextValidator;->validateSimple(Ljava/lang/String;)Z

    move-result v0

    .line 28
    goto :goto_0

    .line 31
    :pswitch_1
    invoke-direct {p0, p1}, Lcom/poshmark/utils/TextValidator;->validateSimpleNoSpaces(Ljava/lang/String;)Z

    move-result v0

    .line 32
    goto :goto_0

    .line 35
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/poshmark/utils/TextValidator;->validatePassword(Ljava/lang/String;)Z

    move-result v0

    .line 36
    goto :goto_0

    .line 39
    :pswitch_3
    invoke-direct {p0, p1}, Lcom/poshmark/utils/TextValidator;->validateEmail(Ljava/lang/String;)Z

    move-result v0

    .line 40
    goto :goto_0

    .line 43
    :pswitch_4
    invoke-direct {p0, p1}, Lcom/poshmark/utils/TextValidator;->validateUsername(Ljava/lang/String;)Z

    move-result v0

    .line 44
    goto :goto_0

    .line 47
    :pswitch_5
    invoke-direct {p0, p1}, Lcom/poshmark/utils/TextValidator;->validateCreditCardNumber(Ljava/lang/String;)Z

    move-result v0

    .line 48
    goto :goto_0

    .line 51
    :pswitch_6
    invoke-direct {p0, p1}, Lcom/poshmark/utils/TextValidator;->validateZipcode(Ljava/lang/String;)Z

    move-result v0

    .line 52
    goto :goto_0

    .line 24
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public setValidatorMode(Lcom/poshmark/utils/TextValidator$MODE;)V
    .locals 0
    .param p1, "mode"    # Lcom/poshmark/utils/TextValidator$MODE;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/poshmark/utils/TextValidator;->validatorMode:Lcom/poshmark/utils/TextValidator$MODE;

    .line 20
    return-void
.end method
