.class public Lcom/poshmark/utils/AndroidContacts;
.super Ljava/lang/Object;
.source "AndroidContacts.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/AndroidContacts$Contact;
    }
.end annotation


# instance fields
.field contacts:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/utils/AndroidContacts$Contact;",
            ">;"
        }
    .end annotation
.end field

.field contactsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/utils/AndroidContacts$Contact;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/AndroidContacts;->contactsMap:Ljava/util/Map;

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/AndroidContacts;->contacts:Ljava/util/List;

    .line 112
    return-void
.end method


# virtual methods
.method public getAllPhoneContacts()Ljava/lang/String;
    .locals 18

    .prologue
    .line 25
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 27
    .local v1, "cr":Landroid/content/ContentResolver;
    const/16 v2, 0xa

    new-array v3, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v6, "contact_id"

    aput-object v6, v3, v2

    const/4 v2, 0x1

    const-string v6, "mimetype"

    aput-object v6, v3, v2

    const/4 v2, 0x2

    const-string v6, "data3"

    aput-object v6, v3, v2

    const/4 v2, 0x3

    const-string v6, "data1"

    aput-object v6, v3, v2

    const/4 v2, 0x4

    const-string v6, "data3"

    aput-object v6, v3, v2

    const/4 v2, 0x5

    const-string v6, "data2"

    aput-object v6, v3, v2

    const/4 v2, 0x6

    const-string v6, "display_name"

    aput-object v6, v3, v2

    const/4 v2, 0x7

    const-string v6, "data1"

    aput-object v6, v3, v2

    const/16 v2, 0x8

    const-string v6, "data2"

    aput-object v6, v3, v2

    const/16 v2, 0x9

    const-string v6, "display_name"

    aput-object v6, v3, v2

    .line 39
    .local v3, "projection":[Ljava/lang/String;
    const-string v4, "mimetype = ? OR mimetype = ? OR mimetype = ?"

    .line 40
    .local v4, "where":Ljava/lang/String;
    const/4 v2, 0x3

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v6, "vnd.android.cursor.item/name"

    aput-object v6, v5, v2

    const/4 v2, 0x1

    const-string v6, "vnd.android.cursor.item/email_v2"

    aput-object v6, v5, v2

    const/4 v2, 0x2

    const-string v6, "vnd.android.cursor.item/phone_v2"

    aput-object v6, v5, v2

    .line 45
    .local v5, "whereParameters":[Ljava/lang/String;
    sget-object v2, Landroid/provider/ContactsContract$Data;->CONTENT_URI:Landroid/net/Uri;

    const/4 v6, 0x0

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 47
    .local v10, "cur":Landroid/database/Cursor;
    invoke-interface {v10}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_6

    .line 49
    :cond_0
    :goto_0
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 50
    const-string v2, "contact_id"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    .line 51
    .local v13, "id":Ljava/lang/String;
    const-string v2, "mimetype"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v16

    .line 53
    .local v16, "mimeType":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/utils/AndroidContacts;->contactsMap:Ljava/util/Map;

    invoke-interface {v2, v13}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 55
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/utils/AndroidContacts;->contactsMap:Ljava/util/Map;

    invoke-interface {v2, v13}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/poshmark/utils/AndroidContacts$Contact;

    .line 62
    .local v8, "contact":Lcom/poshmark/utils/AndroidContacts$Contact;
    :goto_1
    const-string v2, "vnd.android.cursor.item/name"

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 64
    const-string v2, "data3"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v8, v2}, Lcom/poshmark/utils/AndroidContacts$Contact;->setLastName(Ljava/lang/String;)V

    .line 65
    const-string v2, "data2"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v8, v2}, Lcom/poshmark/utils/AndroidContacts$Contact;->setFirstName(Ljava/lang/String;)V

    .line 68
    :cond_1
    const-string v2, "vnd.android.cursor.item/phone_v2"

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 70
    const-string v2, "data1"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v17

    .line 71
    .local v17, "number":Ljava/lang/String;
    const-string v2, "data2"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v15

    .line 72
    .local v15, "labelId":I
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v6, "Custom"

    invoke-static {v2, v15, v6}, Landroid/provider/ContactsContract$CommonDataKinds$Phone;->getTypeLabel(Landroid/content/res/Resources;ILjava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v14

    .line 73
    .local v14, "label":Ljava/lang/String;
    if-nez v14, :cond_2

    .line 74
    const-string v14, "other"

    .line 77
    :cond_2
    invoke-virtual {v14}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v17

    invoke-virtual {v8, v2, v0}, Lcom/poshmark/utils/AndroidContacts$Contact;->setContactNumber(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    .end local v14    # "label":Ljava/lang/String;
    .end local v15    # "labelId":I
    .end local v17    # "number":Ljava/lang/String;
    :cond_3
    const-string v2, "vnd.android.cursor.item/email_v2"

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 82
    const-string v2, "data1"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 83
    .local v11, "email":Ljava/lang/String;
    const-string v2, "data3"

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v10, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v14

    .line 84
    .restart local v14    # "label":Ljava/lang/String;
    if-nez v14, :cond_4

    .line 85
    const-string v14, "other"

    .line 86
    :cond_4
    invoke-virtual {v14}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v8, v2, v11}, Lcom/poshmark/utils/AndroidContacts$Contact;->setContactEmail(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 57
    .end local v8    # "contact":Lcom/poshmark/utils/AndroidContacts$Contact;
    .end local v11    # "email":Ljava/lang/String;
    .end local v14    # "label":Ljava/lang/String;
    :cond_5
    new-instance v8, Lcom/poshmark/utils/AndroidContacts$Contact;

    move-object/from16 v0, p0

    invoke-direct {v8, v0}, Lcom/poshmark/utils/AndroidContacts$Contact;-><init>(Lcom/poshmark/utils/AndroidContacts;)V

    .line 58
    .restart local v8    # "contact":Lcom/poshmark/utils/AndroidContacts$Contact;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/utils/AndroidContacts;->contactsMap:Ljava/util/Map;

    invoke-interface {v2, v13, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/utils/AndroidContacts;->contacts:Ljava/util/List;

    invoke-interface {v2, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 90
    .end local v8    # "contact":Lcom/poshmark/utils/AndroidContacts$Contact;
    .end local v13    # "id":Ljava/lang/String;
    .end local v16    # "mimeType":Ljava/lang/String;
    :cond_6
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 93
    new-instance v7, Lcom/google/gson/GsonBuilder;

    invoke-direct {v7}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 94
    .local v7, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v7}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v12

    .line 95
    .local v12, "gson":Lcom/google/gson/Gson;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/poshmark/utils/AndroidContacts;->contacts:Ljava/util/List;

    instance-of v6, v12, Lcom/google/gson/Gson;

    if-nez v6, :cond_7

    invoke-virtual {v12, v2}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    .line 109
    .end local v12    # "gson":Lcom/google/gson/Gson;
    .local v9, "contactsJSON":Ljava/lang/String;
    :goto_2
    return-object v9

    .line 95
    .end local v9    # "contactsJSON":Ljava/lang/String;
    .restart local v12    # "gson":Lcom/google/gson/Gson;
    :cond_7
    check-cast v12, Lcom/google/gson/Gson;

    .end local v12    # "gson":Lcom/google/gson/Gson;
    invoke-static {v12, v2}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    goto :goto_2
.end method
