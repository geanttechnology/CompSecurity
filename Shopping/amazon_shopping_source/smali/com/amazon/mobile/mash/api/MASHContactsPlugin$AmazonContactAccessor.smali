.class Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;
.super Lorg/apache/cordova/contacts/ContactAccessorSdk5;
.source "MASHContactsPlugin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mobile/mash/api/MASHContactsPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AmazonContactAccessor"
.end annotation


# direct methods
.method public constructor <init>(Lorg/apache/cordova/CordovaInterface;)V
    .locals 0
    .param p1, "cordovaInterface"    # Lorg/apache/cordova/CordovaInterface;

    .prologue
    .line 120
    invoke-direct {p0, p1}, Lorg/apache/cordova/contacts/ContactAccessorSdk5;-><init>(Lorg/apache/cordova/CordovaInterface;)V

    .line 121
    return-void
.end method


# virtual methods
.method public buildPopulationSet(Lorg/json/JSONArray;)Ljava/util/HashMap;
    .locals 1
    .param p1, "fields"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 124
    invoke-super {p0, p1}, Lorg/apache/cordova/contacts/ContactAccessorSdk5;->buildPopulationSet(Lorg/json/JSONArray;)Ljava/util/HashMap;

    move-result-object v0

    return-object v0
.end method

.method public getContact(Ljava/lang/String;Lorg/json/JSONArray;)Lorg/json/JSONObject;
    .locals 11
    .param p1, "contactId"    # Ljava/lang/String;
    .param p2, "fields"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v2, 0x0

    const/4 v9, 0x1

    .line 160
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;->mApp:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v0}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/ContactsContract$Data;->CONTENT_URI:Landroid/net/Uri;

    const-string/jumbo v3, "contact_id = ? "

    new-array v4, v9, [Ljava/lang/String;

    aput-object p1, v4, v10

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 163
    .local v6, "c":Landroid/database/Cursor;
    invoke-virtual {p0, p2}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;->buildPopulationSet(Lorg/json/JSONArray;)Ljava/util/HashMap;

    move-result-object v8

    .line 164
    .local v8, "populate":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Boolean;>;"
    invoke-virtual {p0, v9, v8, v6}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin$AmazonContactAccessor;->populateContactArray(ILjava/util/HashMap;Landroid/database/Cursor;)Lorg/json/JSONArray;

    move-result-object v7

    .line 165
    .local v7, "contacts":Lorg/json/JSONArray;
    if-eqz v7, :cond_0

    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ne v0, v9, :cond_0

    .line 166
    invoke-virtual {v7, v10}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 168
    :cond_0
    return-object v2
.end method

.method public populateContactArray(ILjava/util/HashMap;Landroid/database/Cursor;)Lorg/json/JSONArray;
    .locals 7
    .param p1, "limit"    # I
    .param p3, "c"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;",
            "Landroid/database/Cursor;",
            ")",
            "Lorg/json/JSONArray;"
        }
    .end annotation

    .prologue
    .line 135
    .local p2, "populate":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Boolean;>;"
    :try_start_0
    const-class v2, Lorg/apache/cordova/contacts/ContactAccessorSdk5;

    const-string/jumbo v3, "populateContactArray"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-class v6, Ljava/util/HashMap;

    aput-object v6, v4, v5

    const/4 v5, 0x2

    const-class v6, Landroid/database/Cursor;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 137
    .local v1, "populateContactArray":Ljava/lang/reflect/Method;
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 138
    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    const/4 v3, 0x2

    aput-object p3, v2, v3

    invoke-virtual {v1, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/json/JSONArray;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_3

    .line 148
    .end local v1    # "populateContactArray":Ljava/lang/reflect/Method;
    :goto_0
    return-object v2

    .line 139
    :catch_0
    move-exception v0

    .line 140
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    # getter for: Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->access$100()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "populateContactArray: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :goto_1
    const/4 v2, 0x0

    goto :goto_0

    .line 141
    :catch_1
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    # getter for: Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->access$100()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "populateContactArray: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 143
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v0

    .line 144
    .local v0, "e":Ljava/lang/IllegalAccessException;
    # getter for: Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->access$100()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "populateContactArray: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 145
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_3
    move-exception v0

    .line 146
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    # getter for: Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mobile/mash/api/MASHContactsPlugin;->access$100()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "populateContactArray: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method
